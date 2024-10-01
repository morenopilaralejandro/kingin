drop table if exists aux_move_cat;
create temporary table aux_move_cat (
    move_cat_code varchar(32),
    move_cat_name_en varchar(32),
    move_cat_name_ja varchar(32)
);

load data infile '/home/alejandro/eclipse-workspace/kingin/mysql/csv/move-cat.csv'
into table aux_move_cat 
fields terminated by ',' 
enclosed by '"'
lines terminated by '\n'
ignore 1 lines
(
move_cat_code, 
move_cat_name_en, 
move_cat_name_ja
);

delimiter &&
drop procedure if exists proc_insrt_move_cat;
create procedure proc_insrt_move_cat()
begin
	declare i int default 1;

    /*cur1 variables*/
    declare vMoveCatCode varchar(32) default '';
    declare vMoveCatNameEn varchar(32) default '';
    declare vMoveCatNameJa varchar(32) default '';

    declare continueCur1 int default 1;
    declare cur1 cursor for select * from aux_move_cat;
	declare continue handler for SQLSTATE '02000' set continueCur1 = 0;

    delete from move_cat;    
    open cur1;
	while continueCur1=1 do
        fetch cur1 into 
            vMoveCatCode, 
            vMoveCatNameEn, 
            vMoveCatNameJa;

        if continueCur1 = 1 then
            insert into move_cat (
                move_cat_code, 
                move_cat_name_en, 
                move_cat_name_ja
            ) values (
                vMoveCatCode, 
                vMoveCatNameEn, 
                vMoveCatNameJa
            );
        end if;
	end while;
	close cur1;
    drop table if exists aux_move_cat;
end
&&
delimiter ;
call proc_insrt_move_cat();
