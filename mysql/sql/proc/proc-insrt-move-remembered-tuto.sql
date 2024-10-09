drop table if exists aux_move_remembered_tuto;
create temporary table aux_move_remembered_tuto (
    move_name_en varchar(32),
    move_tuto_code varchar(32),
    bp int
);

load data infile '/home/alejandro/eclipse-workspace/kingin/mysql/csv/move-remembered-tuto.csv'
into table aux_move_remembered_tuto 
fields terminated by ',' 
enclosed by '"'
lines terminated by '\n'
ignore 1 lines
(
move_name_en,
move_tuto_code,
bp
);

delimiter &&
drop procedure if exists proc_insrt_move_remembered_tuto;
create procedure proc_insrt_move_remembered_tuto()
begin
	declare i int default 1;

    declare idMove int default 0;
    declare idMoveTuto int default 0;

    /*cur1 variables*/
    declare vMoveNameEn varchar(32) default '';
    declare vMoveTutoCode varchar(32) default '';
    declare vBp int default 0;

    declare continueCur1 int default 1;
    declare cur1 cursor for select * from aux_move_remembered_tuto;
	declare continue handler for SQLSTATE '02000' set continueCur1 = 0;

    delete from move_remembered_tuto;    
    open cur1;
	while continueCur1=1 do
        fetch cur1 into 
            vMoveNameEn,
            vMoveTutoCode,
            vBp;

        set idMove = 0;
        set idMoveTuto = 0;

        if continueCur1 = 1 then
            select move_id into idMove 
                from move 
                where move_name_en = vMoveNameEn;

            select move_tuto_id into idMoveTuto
                from move_tuto 
                where move_tuto_code = vMoveTutoCode;

            insert into move_remembered_tuto (
                move_id,
                move_tuto_id,
                bp
            ) values (
                idMove,
                idMoveTuto,
                vBp
            );
        end if;
	end while;
	close cur1;
    drop table if exists aux_move_remembered_tuto;
end
&&
delimiter ;
call proc_insrt_move_remembered_tuto();
