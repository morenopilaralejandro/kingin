drop table if exists aux_item_pkt;
create temporary table aux_item_pkt (
    item_pkt_code varchar(32),
    item_pkt_name_en varchar(32),	
    item_pkt_name_ja varchar(32)
);

load data infile '/home/alejandro/eclipse-workspace/kingin/mysql/csv/item-pkt.csv'
into table aux_item_pkt 
fields terminated by ',' 
enclosed by '"'
lines terminated by '\n'
ignore 1 lines
(
item_pkt_code,
item_pkt_name_en,	
item_pkt_name_ja
);

delimiter &&
drop procedure if exists proc_insrt_item_pkt;
create procedure proc_insrt_item_pkt()
begin
	declare i int default 1;

    /*cur1 variables*/
    declare vItemPktCode varchar(32) default '';
    declare vItemPktNameEn varchar(32) default '';
    declare vItemPktNameJa varchar(32) default '';

    declare continueCur1 int default 1;
    declare cur1 cursor for select * from aux_item_pkt;
	declare continue handler for SQLSTATE '02000' set continueCur1 = 0;

    delete from item_pkt;    
    open cur1;
	while continueCur1=1 do
        fetch cur1 into v;
        if continueCur1 = 1 then
            /*TODO*/
            insert into item_pkt (
                item_pkt_code,
                item_pkt_name_en,	
                item_pkt_name_ja
            ) values (
                vItemPktCode,
                vItemPktNameEn,
                vItemPktNameJa
            );
        end if;
	end while;
	close cur1;
    drop table if exists aux_item_pkt;
end
&&
delimiter ;
call proc_insrt_item_pkt();
