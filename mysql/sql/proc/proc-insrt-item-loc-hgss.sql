drop table if exists aux_item_loc_hgss;
create temporary table aux_item_loc_hgss (
    zone varchar(32),
    item varchar(32),
    item_obt varchar(32)
);

load data infile '/home/alejandro/eclipse-workspace/kingin/mysql/csv/item-loc-hgss.csv'
into table aux_item_loc_hgss 
fields terminated by ',' 
enclosed by '"'
lines terminated by '\n'
ignore 1 lines
(
zone,
item,
item_obt
);

delimiter &&
drop procedure if exists proc_insrt_item_loc_hgss;
create procedure proc_insrt_item_loc_hgss()
begin
	declare i int default 1;

    declare idItem int default 0;
    declare idZone int default 0;
    declare idItemObt int default 0;

    /*cur1 variables*/
    declare vItem varchar(32) default '';
    declare vZone varchar(32) default '';  
    declare vItemObt varchar(32) default '';  

    declare continueCur1 int default 1;
    declare cur1 cursor for select * from aux_item_loc_hgss;
	declare continue handler for SQLSTATE '02000' set continueCur1 = 0;

    delete from item_loc_hgss;    
    open cur1;
	while continueCur1=1 do
        fetch cur1 into 
            vZone,
            vItem,
            vItemObt;

        set idItem = 0;
        set idZone = 0;
        set idItemObt = 0;

        if continueCur1 = 1 then
            select item_id into idItem 
                from item
                where item_name_en = vItem;

            select zone_id into idZone 
                from zone
                where zone_code = vZone;

            select item_obt_id into idItemObt 
                from item_obt
                where item_obt_code = vItemObt;

            insert into item_loc_hgss (
                item_id,
                zone_id,
                item_obt_id
            ) values (
                idItem,
                idZone,
                idItemObt
            );
        end if;
	end while;
	close cur1;
    drop table if exists aux_item_loc_hgss;
end
&&
delimiter ;
call proc_insrt_item_loc_hgss();
