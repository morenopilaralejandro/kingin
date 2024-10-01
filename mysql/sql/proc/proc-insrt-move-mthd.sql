drop table if exists aux_move_mthd;
create temporary table aux_move_mthd (
    move_mthd_code varchar(32),
    move_mthd_name_en varchar(32),
    move_mthd_name_ja varchar(32)
);

load data infile '/home/alejandro/eclipse-workspace/kingin/mysql/csv/move-mthd.csv'
into table aux_move_mthd 
fields terminated by ',' 
enclosed by '"'
lines terminated by '\n'
ignore 1 lines
(
move_mthd_code,
move_mthd_name_en,
move_mthd_name_ja
);

delimiter &&
drop procedure if exists proc_insrt_move_mthd;
create procedure proc_insrt_move_mthd()
begin
	declare i int default 1;

    /*cur1 variables*/
    declare vMoveMthdCode varchar(32) default '';
    declare vMoveMthdNameEn varchar(32) default '';
    declare vMoveMthdNameJa varchar(32) default '';

    declare continueCur1 int default 1;
    declare cur1 cursor for select * from aux_move_mthd;
	declare continue handler for SQLSTATE '02000' set continueCur1 = 0;

    delete from move_mthd;    
    open cur1;
	while continueCur1=1 do
        fetch cur1 into
            vMoveMthdCode,
            vMoveMthdNameEn,
            vMoveMthdNameJa;
        if continueCur1 = 1 then
            insert into move_mthd (
                move_mthd_code,
                move_mthd_name_en,
                move_mthd_name_ja
            ) values (
                vMoveMthdCode,
                vMoveMthdNameEn,
                vMoveMthdNameJa
            );
        end if;
	end while;
	close cur1;
    drop table if exists aux_move_mthd;
end
&&
delimiter ;
call proc_insrt_move_mthd();
