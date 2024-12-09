drop table if exists aux_shop;
create temporary table aux_shop (
    shop_code varchar(32),
    shop_name_en varchar(32),	
    shop_name_ja varchar(32),
    zone_code varchar(32),
    curr_code varchar(32)
);

load data infile '/home/alejandro/eclipse-workspace/kingin/mysql/csv/shop.csv'
into table aux_shop 
fields terminated by ',' 
enclosed by '"'
lines terminated by '\n'
ignore 1 lines
(
shop_code,
shop_name_en,	
shop_name_ja
zone_code,
curr_code 
);

delimiter &&
drop procedure if exists proc_insrt_shop;
create procedure proc_insrt_shop()
begin
	declare i int default 1;

    declare idZone int default 0;
    declare idCurr int default 0;

    /*cur1 variables*/
    declare vShopCode varchar(32) default '';
    declare vShopNameEn varchar(32) default '';
    declare vShopNameJa varchar(32) default '';
    declare vZoneCode varchar(32) default '';
    declare vCurrCode varchar(32) default '';   

    declare continueCur1 int default 1;
    declare cur1 cursor for select * from aux_shop;
	declare continue handler for SQLSTATE '02000' set continueCur1 = 0;

    delete from shop;    
    open cur1;
	while continueCur1=1 do
        fetch cur1 into 
            vShopCode, 
            vShopNameEn, 
            vShopNameJa
            vZoneCode,
            vCurrCode;
        if continueCur1 = 1 then
            /*TODO*/
            insert into shop (
                shop_code,
                shop_name_en,	
                shop_name_ja,
                zone_id,
                curr_id
            ) values (
                vShopCode,
                vShopNameEn,
                vShopNameJa,
                idZone,
                idCurr
            );
        end if;
	end while;
	close cur1;
    drop table if exists aux_shop;
end
&&
delimiter ;
call proc_insrt_shop();
