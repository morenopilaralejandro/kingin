drop table if exists aux_move_eff;
create temporary table aux_move_eff (
    move_eff_code varchar(32),
    move_eff_desc_en varchar(1000),
    move_eff_desc_ja varchar(1000)
);

load data infile '/home/alejandro/eclipse-workspace/kingin/mysql/csv/move-eff.csv'
into table aux_move_eff 
fields terminated by ',' 
enclosed by '"'
lines terminated by '\n'
ignore 1 lines
(
move_eff_code,
move_eff_desc_en,
move_eff_desc_ja
);

delimiter &&
drop procedure if exists proc_insrt_move_eff;
create procedure proc_insrt_move_eff()
begin
	declare i int default 1;

    /*cur1 variables*/
    declare vMoveEffCode varchar(32) default '';
    declare vMoveEffDescEn varchar(1000) default '';
    declare vMoveEffDescJa varchar(1000) default '';

    declare continueCur1 int default 1;
    declare cur1 cursor for select * from aux_move_eff;
	declare continue handler for SQLSTATE '02000' set continueCur1 = 0;

    delete from move_eff;    
    open cur1;
	while continueCur1=1 do
        fetch cur1 into vMoveEffCode, vMoveEffDescEn, vMoveEffDescJa;
        if continueCur1 = 1 then
            insert into move_eff(
                move_eff_code, 
                move_eff_desc_en, 
                move_eff_desc_ja) 
                values (
                vMoveEffCode, 
                vMoveEffDescEn, 
                vMoveEffDescJa);
        end if;
	end while;
	close cur1;
    drop table if exists aux_move_eff;
end
&&
delimiter ;
call proc_insrt_move_eff();
