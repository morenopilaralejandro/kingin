drop table if exists aux_item;
create temporary table aux_item (
    item_code varchar(32),
    item_img varchar(32),
    item_name_en varchar(32),
    item_name_ja varchar(32),
    item_desc_en varchar(1000),
    item_desc_ja varchar(1000),
    item_price_buy_ye varchar(32),
    item_price_sel_ye varchar(32),
    item_price_buy_bp varchar(32),
    item_price_buy_cn varchar(32),
    item_price_buy_ap varchar(32),
    item_flin varchar(32),
    item_type varchar(32),
    item_pkt varchar(32),
    item_cat varchar(32)
);

load data infile '/home/alejandro/eclipse-workspace/kingin/mysql/csv/item.csv'
into table aux_item 
fields terminated by ',' 
enclosed by '"'
lines terminated by '\n'
ignore 1 lines
(
item_code,
item_img,
item_name_en,
item_name_ja,
item_desc_en,
item_desc_ja,
item_price_buy_ye,
item_price_sel_ye,
item_price_buy_bp,
item_price_buy_cn,
item_price_buy_ap,
item_flin,
item_type,
item_pkt,
item_cat
);

delimiter &&
drop procedure if exists proc_insrt_item;
create procedure proc_insrt_item()
begin
	declare i int default 1;

    declare idItemType int default 0;
    declare idItemPkt int default 0;
    declare idItemCat int default 0;

    declare intBuyYe int default 0; 
    declare intSelYe int default 0; 
    declare intBuyBp int default 0; 
    declare intBuyCn int default 0; 
    declare intBuyAp int default 0;
    declare intFlin int default 0;

    /*cur1 variables*/
    declare vItemCode varchar(32) default '';
    declare vItemImg varchar(32) default '';
    declare vItemNameEn varchar(32) default '';
    declare vItemNameJa varchar(32) default '';
    declare vItemDescEn varchar(1000) default '';
    declare vItemDescJa varchar(1000) default '';
    declare vItemPriceBuyYe varchar(32) default '';
    declare vItemPriceSelYe varchar(32) default '';
    declare vItemPriceBuyBp varchar(32) default '';
    declare vItemPriceBuyCn varchar(32) default '';
    declare vItemPriceBuyAp varchar(32) default '';
    declare vItemFlin varchar(32) default '';
    declare vItemType varchar(32) default '';
    declare vItemPkt varchar(32) default '';
    declare vItemCat varchar(32) default '';


    declare continueCur1 int default 1;
    declare cur1 cursor for select * from aux_item;
	declare continue handler for SQLSTATE '02000' set continueCur1 = 0;

    delete from item;    
    open cur1;
	while continueCur1=1 do
        fetch cur1 into
            vItemCode,
            vItemImg,
            vItemNameEn,
            vItemNameJa,
            vItemDescEn,
            vItemDescJa,
            vItemPriceBuyYe,
            vItemPriceSelYe,
            vItemPriceBuyBp,
            vItemPriceBuyCn,
            vItemPriceBuyAp,
            vItemFlin,
            vItemType,
            vItemPkt,
            vItemCat;

        set intBuyYe = 0;
        set intSelYe = 0;
        set intBuyBp = 0;
        set intBuyCn = 0;
        set intBuyAp = 0;
        set intFlin = 0;

        if continueCur1 = 1 then
            select item_type_id into idItemType 
                from item_type
                where item_type_code = vItemType;

            select item_pkt_id into idItemPkt 
                from item_pkt
                where item_pkt_code = vItemPkt;

            select item_cat_id into idItemCat 
                from item_cat
                where item_cat_code = vItemCat;

            set continueCur1 = 1;            

            if vItemPriceBuyYe  = 'null' then
                set intBuyYe = null;
            else
                set intBuyYe = cast(vItemPriceBuyYe as unsigned);
            end if; 

            if vItemPriceSelYe  = 'null' then
                set intSelYe = null;
            else
                set intSelYe = cast(vItemPriceSelYe as unsigned);
            end if; 

            if vItemPriceBuyBp  = 'null' then
                set intBuyBp = null;
            else
                set intBuyBp = cast(vItemPriceBuyBp as unsigned);
            end if; 

            if vItemPriceBuyCn  = 'null' then
                set intBuyCn = null;
            else
                set intBuyCn = cast(vItemPriceBuyCn as unsigned);
            end if; 

            if vItemPriceBuyAp  = 'null' then
                set intBuyAp = null;
            else
                set intBuyAp = cast(vItemPriceBuyAp as unsigned);
            end if;

            if vItemFlin  = 'null' then
                set intFlin = null;
            else
                set intFlin = cast(vItemFlin as unsigned);
            end if; 

            insert into item (
                item_code,
                item_img,
                item_name_en,
                item_name_ja,
                item_desc_en,
                item_desc_ja,
                item_price_buy_ye,
                item_price_sel_ye,
                item_price_buy_bp,
                item_price_buy_cn,
                item_price_buy_ap,
                item_flin,
                item_type_id,
                item_pkt_id,
                item_cat_id
            ) values (
                vItemCode
                vItemImg,
                vItemNameEn,
                vItemNameJa,
                vItemDescEn,
                vItemDescJa,
                intBuyYe,
                intSelYe,
                intBuyBp,
                intBuyCn,
                intBuyAp,
                intFlin,
                idItemType,
                idItemPkt,
                idItemCat
            );
        end if;
        set i = i + 1;
	end while;
	close cur1;
    drop table if exists aux_item;
end
&&
delimiter ;
call proc_insrt_item();
