drop table if exists aux_shop_sell_item;
create temporary table aux_shop_sell_item (
    item_name varchar(32),
    shop_code varchar(32)
);

load data infile '/home/alejandro/eclipse-workspace/kingin/mysql/csv/shop-sell-item.csv'
into table aux_shop_sell_item 
fields terminated by ',' 
enclosed by '"'
lines terminated by '\n'
ignore 1 lines
(
item_name,
shop_code
);

delimiter &&
drop procedure if exists proc_insrt_shop_sell_item;
create procedure proc_insrt_shop_sell_item()
begin
	declare i int default 1;

    declare idShop int default 0;
    declare idItem int default 0;

    /*cur1 variables*/
    declare vShopCode varchar(32) default '';
    declare vItemName varchar(32) default '';    

    declare continueCur1 int default 1;
    declare cur1 cursor for select * from aux_shop_sell_item;
	declare continue handler for SQLSTATE '02000' set continueCur1 = 0;

    delete from shop_sell_item;    
    open cur1;
	while continueCur1=1 do
        fetch cur1 into 
            vItemName,
            vShopCode;

        select 
            vItemName,
            vShopCode;

        set idShop = 0;
        set idItem = 0;

        if continueCur1 = 1 then
            select shop_id into idShop 
                from shop 
                where shop_code = vShopCode;

            select item_id into idItem 
                from item 
                where item_name_en = vItemName;

            insert into shop_sell_item (
                shop_id,
                item_id
            ) values (
                idShop,
                idItem
            );
        end if;
	end while;
	close cur1;
    drop table if exists aux_shop_sell_item;
end
&&
delimiter ;
call proc_insrt_shop_sell_item();
