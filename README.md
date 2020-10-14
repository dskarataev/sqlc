Forked from [kyleconroy/sqlc](https://github.com/kyleconroy/sqlc). Find detailed docs there.
 - Added file name prefix for golang generated files

## Usage

```
Usage:
  sqlc [command]

Available Commands:
  compile     Statically check SQL for syntax and type errors
  generate    Generate Go code from SQL
  help        Help about any command
  init        Create an empty sqlc.yaml settings file
  version     Print the sqlc version number

Flags:
  -h, --help   help for sqlc

Use "sqlc [command] --help" for more information about a command.
```

## Settings

The `sqlc` tool is configured via a `sqlc.yaml` file. This file must be
in the directory where the `sqlc` command is run.

```yaml
version: "1"
packages:
  - name: "db"
    path: "internal/db"
    queries: "./sql/query/"
    schema: "./sql/schema/"
    engine: "postgresql"
    file_prefix: "z_"
    emit_json_tags: true
    emit_prepared_queries: true
    emit_interface: false
    emit_exact_table_names: false
    emit_empty_slices: false
```

Each package document has the following keys:
- `name`:
  - The package name to use for the generated code. Defaults to `path` basename
- `path`:
  - Output directory for generated code
- `queries`:
  - Directory of SQL queries or path to single SQL file
- `schema`:
  - Directory of SQL migrations or path to single SQL file
- `engine`:
  - Either `postgresql` or `mysql`. Defaults to `postgresql`. MySQL support is experimental
- `file_prefix`:
   - Add prefix string to filenames. ex. `z_models.go`. Default is empty.
- `emit_json_tags`:
  - If true, add JSON tags to generated structs. Defaults to `false`.
- `emit_prepared_queries`:
  - If true, include support for prepared queries. Defaults to `false`.
- `emit_interface`:
  - If true, output a `Querier` interface in the generated package. Defaults to `false`.
- `emit_exact_table_names`:
  - If true, struct names will mirror table names. Otherwise, sqlc attempts to singularize plural table names. Defaults to `false`.
- `emit_empty_slices`:
  - If true, slices returned by `:many` queries will be empty instead of `nil`. Defaults to `false`.


## Installation

### go get

```
go get github.com/vitthalaa/sqlc/cmd/sqlc
```

Find more documentation here: https://github.com/kyleconroy/sqlc