drop table if exists aux_item_mach;
create temporary table aux_item_mach (
    item varchar(32),
    item_mach_num int,
    item_mach_obt varchar(32),
    move varchar(32)
);

load data infile '/home/alejandro/eclipse-workspace/kingin/mysql/csv/item-mach.csv'
into table aux_item_mach 
fields terminated by ',' 
enclosed by '"'
lines terminated by '\n'
ignore 1 lines
(
item,
item_mach_num,
item_mach_obt,
move
);

delimiter &&
drop procedure if exists proc_insrt_item_mach;
create procedure proc_insrt_item_mach()
begin
	declare i int default 1;

    declare idItem int default 0;
    declare idItemMachObt int default 0;
    declare idMove int default 0;

    /*cur1 variables*/
    declare vItem varchar(32) default '';
    declare vItemMachNum int default 0;
    declare vItemMachObt varchar(32) default '';
    declare vMove varchar(32) default '';

    declare continueCur1 int default 1;
    declare cur1 cursor for select * from aux_item_mach;
	declare continue handler for SQLSTATE '02000' set continueCur1 = 0;

    delete from item_mach;    
    open cur1;
	while continueCur1=1 do
        fetch cur1 into
            vItem,
            vItemMachNum,
            vItemMachObt,
            vMove;

        if continueCur1 = 1 then
            select item_id into idItem 
                from item
                where item_code = vItem;

            select item_mach_obt_id into idItemMachObt 
                from item_mach_obt
                where item_mach_obt_code = vItemMachObt;

            select move_id into idMove 
                from move
                where move_name_en = vMove;

            set continueCur1 = 1;            

            insert into item_mach (
                item_mach_id,
                item_mach_num,
                item_mach_obt_id,
                move_id
            ) values (
                idItem,
                vItemMachNum,
                idItemMachObt,
                idMove
            );
        end if;
        set i = i + 1;
	end while;
	close cur1;
    drop table if exists aux_item_mach;
end
&&
delimiter ;
call proc_insrt_item_mach();
