package sqlite

import "github.com/vitthalaa/sqlc/internal/sql/catalog"

func NewCatalog() *catalog.Catalog {
	c := catalog.New("main")
	return c
}
