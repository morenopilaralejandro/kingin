drop table if exists aux_move_tuto;
create temporary table aux_move_tuto (
    move_tuto_code varchar(32),
    move_tuto_name_en varchar(32),
    move_tuto_name_ja varchar(32)
);

load data infile '/home/alejandro/eclipse-workspace/kingin/mysql/csv/move-tuto.csv'
into table aux_move_tuto 
fields terminated by ',' 
enclosed by '"'
lines terminated by '\n'
ignore 1 lines
(
move_tuto_code,
move_tuto_name_en,
move_tuto_name_ja
);

delimiter &&
drop procedure if exists proc_insrt_move_tuto;
create procedure proc_insrt_move_tuto()
begin
	declare i int default 1;

    /*cur1 variables*/
    declare vMoveTutoCode varchar(32) default '';
    declare vMoveTutoNameEn varchar(32) default '';
    declare vMoveTutoNameJa varchar(32) default '';

    declare continueCur1 int default 1;
    declare cur1 cursor for select * from aux_move_tuto;
	declare continue handler for SQLSTATE '02000' set continueCur1 = 0;

    delete from move_tuto;    
    open cur1;
	while continueCur1=1 do
        fetch cur1 into
            vMoveTutoCode,
            vMoveTutoNameEn,
            vMoveTutoNameJa;
        if continueCur1 = 1 then
            insert into move_tuto (
                move_tuto_code,
                move_tuto_name_en,
                move_tuto_name_ja
            ) values (
                vMoveTutoCode,
                vMoveTutoNameEn,
                vMoveTutoNameJa
            );
        end if;
	end while;
	close cur1;
    drop table if exists aux_move_tuto;
end
&&
delimiter ;
call proc_insrt_move_tuto();
