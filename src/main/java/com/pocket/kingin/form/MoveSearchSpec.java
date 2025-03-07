package com.pocket.kingin.form;

import org.springframework.data.jpa.domain.Specification;

import com.pocket.kingin.domain.Move;
import com.pocket.kingin.domain.MoveCat;
import com.pocket.kingin.domain.Type;

public class MoveSearchSpec {
	public static final String ID = "moveId";
	public static final String MOVE_NAME_EN = "moveNameEn";
	public static final String MOVE_NAME_JA = "moveNameJa";
	public static final String TYPE = "type";
	public static final String MOVE_CAT = "moveCat";

	private MoveSearchSpec() {
	}

	private static Specification<Move> hasMoveNameEn(String moveNameEn) {
		return ((root, query, cb) -> moveNameEn == null || moveNameEn.isEmpty() ? cb.conjunction()
				: cb.like(root.get(MOVE_NAME_EN), moveNameEn + '%'));
	}

	private static Specification<Move> hasMoveNameJa(String moveNameJa) {
		return ((root, query, cb) -> moveNameJa == null || moveNameJa.isEmpty() ? cb.conjunction()
				: cb.like(root.get(MOVE_NAME_JA), moveNameJa + '%'));
	}

	private static Specification<Move> hasType(Type type) {
		return ((root, query, cb) -> type == null ? cb.conjunction() : cb.equal(root.get(TYPE), type));
	}

	private static Specification<Move> hasMoveCat(MoveCat moveCat) {
		return ((root, query, cb) -> moveCat == null ? cb.conjunction() : cb.equal(root.get(MOVE_CAT), moveCat));
	}

	public static Specification<Move> moveSearch(MoveSearch moveSearch, String lang) {
		switch (lang) {
		case "ja":
			return Specification.where(hasMoveNameJa(moveSearch.getMoveName())
					.and(hasType(moveSearch.getTypeObj())
					.and(hasMoveCat(moveSearch.getMoveCatObj()))));
		default:
			return Specification.where(hasMoveNameEn(moveSearch.getMoveName())
					.and(hasType(moveSearch.getTypeObj())
					.and(hasMoveCat(moveSearch.getMoveCatObj()))));
		}
	}
}
