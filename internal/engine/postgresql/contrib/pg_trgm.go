// Code generated by sqlc-pg-gen. DO NOT EDIT.

package contrib

import (
	"github.com/vitthalaa/sqlc/internal/sql/ast"
	"github.com/vitthalaa/sqlc/internal/sql/catalog"
)

func PgTrgm() *catalog.Schema {
	s := &catalog.Schema{Name: "pg_catalog"}
	s.Funcs = []*catalog.Function{
		{
			Name: "gtrgm_in",
			Args: []*catalog.Argument{
				{
					Type: &ast.TypeName{Name: "cstring"},
				},
			},
			ReturnType: &ast.TypeName{Name: "gtrgm"},
		},
		{
			Name: "gtrgm_out",
			Args: []*catalog.Argument{
				{
					Type: &ast.TypeName{Name: "gtrgm"},
				},
			},
			ReturnType: &ast.TypeName{Name: "cstring"},
		},
		{
			Name: "set_limit",
			Args: []*catalog.Argument{
				{
					Type: &ast.TypeName{Name: "real"},
				},
			},
			ReturnType: &ast.TypeName{Name: "real"},
		},
		{
			Name:       "show_limit",
			Args:       []*catalog.Argument{},
			ReturnType: &ast.TypeName{Name: "real"},
		},
		{
			Name: "show_trgm",
			Args: []*catalog.Argument{
				{
					Type: &ast.TypeName{Name: "text"},
				},
			},
			ReturnType: &ast.TypeName{Name: "text[]"},
		},
		{
			Name: "similarity",
			Args: []*catalog.Argument{
				{
					Type: &ast.TypeName{Name: "text"},
				},
				{
					Type: &ast.TypeName{Name: "text"},
				},
			},
			ReturnType: &ast.TypeName{Name: "real"},
		},
		{
			Name: "similarity_dist",
			Args: []*catalog.Argument{
				{
					Type: &ast.TypeName{Name: "text"},
				},
				{
					Type: &ast.TypeName{Name: "text"},
				},
			},
			ReturnType: &ast.TypeName{Name: "real"},
		},
		{
			Name: "similarity_op",
			Args: []*catalog.Argument{
				{
					Type: &ast.TypeName{Name: "text"},
				},
				{
					Type: &ast.TypeName{Name: "text"},
				},
			},
			ReturnType: &ast.TypeName{Name: "boolean"},
		},
		{
			Name: "strict_word_similarity",
			Args: []*catalog.Argument{
				{
					Type: &ast.TypeName{Name: "text"},
				},
				{
					Type: &ast.TypeName{Name: "text"},
				},
			},
			ReturnType: &ast.TypeName{Name: "real"},
		},
		{
			Name: "strict_word_similarity_commutator_op",
			Args: []*catalog.Argument{
				{
					Type: &ast.TypeName{Name: "text"},
				},
				{
					Type: &ast.TypeName{Name: "text"},
				},
			},
			ReturnType: &ast.TypeName{Name: "boolean"},
		},
		{
			Name: "strict_word_similarity_dist_commutator_op",
			Args: []*catalog.Argument{
				{
					Type: &ast.TypeName{Name: "text"},
				},
				{
					Type: &ast.TypeName{Name: "text"},
				},
			},
			ReturnType: &ast.TypeName{Name: "real"},
		},
		{
			Name: "strict_word_similarity_dist_op",
			Args: []*catalog.Argument{
				{
					Type: &ast.TypeName{Name: "text"},
				},
				{
					Type: &ast.TypeName{Name: "text"},
				},
			},
			ReturnType: &ast.TypeName{Name: "real"},
		},
		{
			Name: "strict_word_similarity_op",
			Args: []*catalog.Argument{
				{
					Type: &ast.TypeName{Name: "text"},
				},
				{
					Type: &ast.TypeName{Name: "text"},
				},
			},
			ReturnType: &ast.TypeName{Name: "boolean"},
		},
		{
			Name: "word_similarity",
			Args: []*catalog.Argument{
				{
					Type: &ast.TypeName{Name: "text"},
				},
				{
					Type: &ast.TypeName{Name: "text"},
				},
			},
			ReturnType: &ast.TypeName{Name: "real"},
		},
		{
			Name: "word_similarity_commutator_op",
			Args: []*catalog.Argument{
				{
					Type: &ast.TypeName{Name: "text"},
				},
				{
					Type: &ast.TypeName{Name: "text"},
				},
			},
			ReturnType: &ast.TypeName{Name: "boolean"},
		},
		{
			Name: "word_similarity_dist_commutator_op",
			Args: []*catalog.Argument{
				{
					Type: &ast.TypeName{Name: "text"},
				},
				{
					Type: &ast.TypeName{Name: "text"},
				},
			},
			ReturnType: &ast.TypeName{Name: "real"},
		},
		{
			Name: "word_similarity_dist_op",
			Args: []*catalog.Argument{
				{
					Type: &ast.TypeName{Name: "text"},
				},
				{
					Type: &ast.TypeName{Name: "text"},
				},
			},
			ReturnType: &ast.TypeName{Name: "real"},
		},
		{
			Name: "word_similarity_op",
			Args: []*catalog.Argument{
				{
					Type: &ast.TypeName{Name: "text"},
				},
				{
					Type: &ast.TypeName{Name: "text"},
				},
			},
			ReturnType: &ast.TypeName{Name: "boolean"},
		},
	}
	return s
}
