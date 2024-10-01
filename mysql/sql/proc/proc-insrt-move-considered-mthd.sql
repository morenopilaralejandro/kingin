drop table if exists aux_move_considered_mthd;
create temporary table aux_move_considered_mthd (
    move_mthd_code varchar(32),
    move_name_en varchar(32)
);

load data infile '/home/alejandro/eclipse-workspace/kingin/mysql/csv/move-considered-mthd.csv'
into table aux_move_considered_mthd 
fields terminated by ',' 
enclosed by '"'
lines terminated by '\n'
ignore 1 lines
(
move_mthd_code,
move_name_en
);

delimiter &&
drop procedure if exists proc_insrt_move_considered_mthd;
create procedure proc_insrt_move_considered_mthd()
begin
	declare i int default 1;

    declare idMoveMthd int default 0;
    declare idMove int default 0;

    /*cur1 variables*/
    declare vMoveMthdCode varchar(32) default '';
    declare vMoveNameEn varchar(32) default '';

    declare continueCur1 int default 1;
    declare cur1 cursor for select * from aux_move_considered_mthd;
	declare continue handler for SQLSTATE '02000' set continueCur1 = 0;

    delete from move_considered_mthd;    
    open cur1;
	while continueCur1=1 do
        fetch cur1 into 
            vMoveMthdCode,
            vMoveNameEn;

        set idMoveMthd = 0;
        set idMove = 0;

        if continueCur1 = 1 then
            select move_mthd_id into idMoveMthd 
                from move_mthd 
                where move_mthd_code = vMoveMthdCode;

            select move_id into idMove 
                from move 
                where move_name_en = vMoveNameEn;

            set continueCur1 = 1;

            if idMove != 0 then 
                insert into move_considered_mthd (
                    move_id,
                    move_mthd_id
                ) values (
                    idMove,
                    idMoveMthd
                );
            end if;
        end if;
	end while;
	close cur1;
    drop table if exists aux_move_considered_mthd;
end
&&
delimiter ;
call proc_insrt_move_considered_mthd();
