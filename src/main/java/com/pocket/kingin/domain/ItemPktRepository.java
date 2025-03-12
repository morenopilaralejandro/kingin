package com.pocket.kingin.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPktRepository extends JpaRepository<ItemPkt, Long> {
	List<ItemPkt> findByItemPktCode(String code);
}
