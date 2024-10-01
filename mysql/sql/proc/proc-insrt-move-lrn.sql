drop table if exists aux_move_lrn;
create temporary table aux_move_lrn (
    move_lrn_code varchar(32),
    move_lrn_name_en varchar(32),
    move_lrn_name_ja varchar(32)
);

load data infile '/home/alejandro/eclipse-workspace/kingin/mysql/csv/move-lrn.csv'
into table aux_move_lrn 
fields terminated by ',' 
enclosed by '"'
lines terminated by '\n'
ignore 1 lines
(
move_lrn_code,
move_lrn_name_en,
move_lrn_name_ja
);

delimiter &&
drop procedure if exists proc_insrt_move_lrn;
create procedure proc_insrt_move_lrn()
begin
	declare i int default 1;

    /*cur1 variables*/
    declare vMoveLrnCode varchar(32) default '';
    declare vMoveLrnNameEn varchar(32) default '';
    declare vMoveLrnNameJa varchar(32) default '';

    declare continueCur1 int default 1;
    declare cur1 cursor for select * from aux_move_lrn;
	declare continue handler for SQLSTATE '02000' set continueCur1 = 0;

    delete from move_lrn;    
    open cur1;
	while continueCur1=1 do
        fetch cur1 into
            vMoveLrnCode,
            vMoveLrnNameEn,
            vMoveLrnNameJa;

        if continueCur1 = 1 then
            insert into move_lrn (
                move_lrn_code,
                move_lrn_name_en,
                move_lrn_name_ja
            ) values (
                vMoveLrnCode,
                vMoveLrnNameEn,
                vMoveLrnNameJa
            );
        end if;
	end while;
	close cur1;
    drop table if exists aux_move_lrn;
end
&&
delimiter ;
call proc_insrt_move_lrn();
