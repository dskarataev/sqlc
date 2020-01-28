// Code generated by sqlc. DO NOT EDIT.

package com.example.ondeck

import java.sql.Connection
import java.sql.SQLException
import java.sql.Types
import java.time.LocalDateTime

const val createCity = """-- name: createCity :one
INSERT INTO city (
    name,
    slug
) VALUES (
    ?,
    ?
) RETURNING slug, name
"""

data class CreateCityParams (
  val name: String,
  val slug: String
)

const val createVenue = """-- name: createVenue :one
INSERT INTO venue (
    slug,
    name,
    city,
    created_at,
    spotify_playlist,
    status,
    statuses,
    tags
) VALUES (
    ?,
    ?,
    ?,
    NOW(),
    ?,
    ?,
    ?,
    ?
) RETURNING id
"""

data class CreateVenueParams (
  val slug: String,
  val name: String,
  val city: String,
  val spotifyPlaylist: String,
  val status: Status,
  val statuses: List<Status>,
  val tags: List<String>
)

const val deleteVenue = """-- name: deleteVenue :exec
DELETE FROM venue
WHERE slug = ? AND slug = ?
"""

const val getCity = """-- name: getCity :one
SELECT slug, name
FROM city
WHERE slug = ?
"""

const val getVenue = """-- name: getVenue :one
SELECT id, status, statuses, slug, name, city, spotify_playlist, songkick_id, tags, created_at
FROM venue
WHERE slug = ? AND city = ?
"""

data class GetVenueParams (
  val slug: String,
  val city: String
)

const val listCities = """-- name: listCities :many
SELECT slug, name
FROM city
ORDER BY name
"""

const val listVenues = """-- name: listVenues :many
SELECT id, status, statuses, slug, name, city, spotify_playlist, songkick_id, tags, created_at
FROM venue
WHERE city = ?
ORDER BY name
"""

const val updateCityName = """-- name: updateCityName :exec
UPDATE city
SET name = ?
WHERE slug = ?
"""

data class UpdateCityNameParams (
  val name: String,
  val slug: String
)

const val updateVenueName = """-- name: updateVenueName :one
UPDATE venue
SET name = ?
WHERE slug = ?
RETURNING id
"""

data class UpdateVenueNameParams (
  val name: String,
  val slug: String
)

const val venueCountByCity = """-- name: venueCountByCity :many
SELECT
    city,
    count(*)
FROM venue
GROUP BY 1
ORDER BY 1
"""

data class VenueCountByCityRow (
  val city: String,
  val count: Long
)

class QueriesImpl(private val conn: Connection) : Queries {

// Create a new city. The slug must be unique.
// This is the second line of the comment
// This is the third line

  @Throws(SQLException::class)
  override fun createCity(arg: CreateCityParams): City {
    val stmt = conn.prepareStatement(createCity)
    stmt.setString(1, arg.name)
    stmt.setString(2, arg.slug)

    return stmt.executeQuery().use { results ->
      if (!results.next()) {
        throw SQLException("no rows in result set")
      }
      val ret = City(
      results.getString(1),
      results.getString(2)
    )
      if (results.next()) {
          throw SQLException("expected one row in result set, but got many")
      }
      ret
    }
  }

  @Throws(SQLException::class)
  override fun createVenue(arg: CreateVenueParams): Int {
    val stmt = conn.prepareStatement(createVenue)
    stmt.setString(1, arg.slug)
    stmt.setString(2, arg.name)
    stmt.setString(3, arg.city)
    stmt.setString(4, arg.spotifyPlaylist)
    stmt.setObject(5, arg.status.value, Types.OTHER)
    stmt.setArray(6, conn.createArrayOf("status", arg.statuses.map { v -> v.value }.toTypedArray()))
    stmt.setArray(7, conn.createArrayOf("text", arg.tags.toTypedArray()))

    return stmt.executeQuery().use { results ->
      if (!results.next()) {
        throw SQLException("no rows in result set")
      }
      val ret = results.getInt(1)
      if (results.next()) {
          throw SQLException("expected one row in result set, but got many")
      }
      ret
    }
  }

  @Throws(SQLException::class)
  override fun deleteVenue(slug: String) {
    val stmt = conn.prepareStatement(deleteVenue)
    stmt.setString(1, slug)
    stmt.setString(2, slug)

    stmt.execute()
    stmt.close()
  }

  @Throws(SQLException::class)
  override fun getCity(slug: String): City {
    val stmt = conn.prepareStatement(getCity)
    stmt.setString(1, slug)

    return stmt.executeQuery().use { results ->
      if (!results.next()) {
        throw SQLException("no rows in result set")
      }
      val ret = City(
      results.getString(1),
      results.getString(2)
    )
      if (results.next()) {
          throw SQLException("expected one row in result set, but got many")
      }
      ret
    }
  }

  @Throws(SQLException::class)
  override fun getVenue(arg: GetVenueParams): Venue {
    val stmt = conn.prepareStatement(getVenue)
    stmt.setString(1, arg.slug)
    stmt.setString(2, arg.city)

    return stmt.executeQuery().use { results ->
      if (!results.next()) {
        throw SQLException("no rows in result set")
      }
      val ret = Venue(
      results.getInt(1),
      Status.lookup(results.getString(2))!!,
      (results.getArray(3).array as Array<String>).map { v -> Status.lookup(v)!! }.toList(),
      results.getString(4),
      results.getString(5),
      results.getString(6),
      results.getString(7),
      results.getString(8),
      (results.getArray(9).array as Array<String>).toList(),
      results.getObject(10, LocalDateTime::class.java)
    )
      if (results.next()) {
          throw SQLException("expected one row in result set, but got many")
      }
      ret
    }
  }

  @Throws(SQLException::class)
  override fun listCities(): List<City> {
    val stmt = conn.prepareStatement(listCities)
    
    return stmt.executeQuery().use { results ->
      val ret = mutableListOf<City>()
      while (results.next()) {
          ret.add(City(
      results.getString(1),
      results.getString(2)
    ))
      }
      ret
    }
  }

  @Throws(SQLException::class)
  override fun listVenues(city: String): List<Venue> {
    val stmt = conn.prepareStatement(listVenues)
    stmt.setString(1, city)

    return stmt.executeQuery().use { results ->
      val ret = mutableListOf<Venue>()
      while (results.next()) {
          ret.add(Venue(
      results.getInt(1),
      Status.lookup(results.getString(2))!!,
      (results.getArray(3).array as Array<String>).map { v -> Status.lookup(v)!! }.toList(),
      results.getString(4),
      results.getString(5),
      results.getString(6),
      results.getString(7),
      results.getString(8),
      (results.getArray(9).array as Array<String>).toList(),
      results.getObject(10, LocalDateTime::class.java)
    ))
      }
      ret
    }
  }

  @Throws(SQLException::class)
  override fun updateCityName(arg: UpdateCityNameParams) {
    val stmt = conn.prepareStatement(updateCityName)
    stmt.setString(1, arg.name)
    stmt.setString(2, arg.slug)

    stmt.execute()
    stmt.close()
  }

  @Throws(SQLException::class)
  override fun updateVenueName(arg: UpdateVenueNameParams): Int {
    val stmt = conn.prepareStatement(updateVenueName)
    stmt.setString(1, arg.name)
    stmt.setString(2, arg.slug)

    return stmt.executeQuery().use { results ->
      if (!results.next()) {
        throw SQLException("no rows in result set")
      }
      val ret = results.getInt(1)
      if (results.next()) {
          throw SQLException("expected one row in result set, but got many")
      }
      ret
    }
  }

  @Throws(SQLException::class)
  override fun venueCountByCity(): List<VenueCountByCityRow> {
    val stmt = conn.prepareStatement(venueCountByCity)
    
    return stmt.executeQuery().use { results ->
      val ret = mutableListOf<VenueCountByCityRow>()
      while (results.next()) {
          ret.add(VenueCountByCityRow(
      results.getString(1),
      results.getLong(2)
    ))
      }
      ret
    }
  }

}

