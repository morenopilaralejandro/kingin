drop table if exists aux_move_trgt;
create temporary table aux_move_trgt (
    move_trgt_code varchar(32),
    move_trgt_name_en varchar(32),
    move_trgt_name_ja varchar(32)
);

load data infile '/home/alejandro/eclipse-workspace/kingin/mysql/csv/move-trgt.csv'
into table aux_move_trgt 
fields terminated by ',' 
enclosed by '"'
lines terminated by '\n'
ignore 1 lines
(
move_trgt_code,
move_trgt_name_en,
move_trgt_name_ja
);

delimiter &&
drop procedure if exists proc_insrt_move_trgt;
create procedure proc_insrt_move_trgt()
begin
	declare i int default 1;

    /*cur1 variables*/
    declare vMoveTrgtCode varchar(32) default '';
    declare vMoveTrgtNameEn varchar(32) default '';
    declare vMoveTrgtNameJa varchar(32) default '';


    declare continueCur1 int default 1;
    declare cur1 cursor for select * from aux_move_trgt;
	declare continue handler for SQLSTATE '02000' set continueCur1 = 0;

    delete from move_trgt;    
    open cur1;
	while continueCur1=1 do
        fetch cur1 into v;
        if continueCur1 = 1 then
            insert into move_trgt(
                move_trgt_code,
                move_trgt_name_en,
                move_trgt_name_ja) 
                values (
                vMoveTrgtCode
                vMoveTrgtNameEn
                vMoveTrgtNameJa);
        end if;
	end while;
	close cur1;
    drop table if exists aux_move_trgt;
end
&&
delimiter ;
call proc_insrt_move_trgt();
