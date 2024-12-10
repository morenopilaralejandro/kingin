drop table if exists aux_shop_exch_pd;
create temporary table aux_shop_exch_pd (
    shop_code varchar(32),
    pd_name varchar(32),
    price int
);

load data infile '/home/alejandro/eclipse-workspace/kingin/mysql/csv/shop-exch-pd.csv'
into table aux_shop_exch_pd 
fields terminated by ',' 
enclosed by '"'
lines terminated by '\n'
ignore 1 lines
(
shop_code,
pd_name,
price
);

delimiter &&
drop procedure if exists proc_insrt_shop_exch_pd;
create procedure proc_insrt_shop_exch_pd()
begin
	declare i int default 1;

    declare idShop int default 0;
    declare idPd int default 0;

    /*cur1 variables*/
    declare vShopCode varchar(32) default '';
    declare vPdName varchar(32) default '';    
    declare vPrice varchar(32) default '';

    declare continueCur1 int default 1;
    declare cur1 cursor for select * from aux_shop_exch_pd;
	declare continue handler for SQLSTATE '02000' set continueCur1 = 0;

    delete from shop_exch_pd;    
    open cur1;
	while continueCur1=1 do
        fetch cur1 into 
            vShopCode,
            vPdName,
            vPrice;

        set idShop = 0;
        set idPd = 0;

        if continueCur1 = 1 then
            select shop_id into idShop 
                from shop 
                where shop_code = vShopCode;

            select pd_id into idPd 
                from pd 
                where pd_name_en = vPdName;

            insert into shop_exch_pd (
                shop_id,
                pd_id,
                price
            ) values (
                idShop,
                idPd,
                vPrice
            );
        end if;
	end while;
	close cur1;
    drop table if exists aux_shop_exch_pd;
end
&&
delimiter ;
call proc_insrt_shop_exch_pd();
