drop table if exists aux_move_cause_eff;
create temporary table aux_move_cause_eff (
    move_code varchar(32),
    move_eff_code varchar(32),
    rate varchar(32)
);

load data infile '/home/alejandro/eclipse-workspace/kingin/mysql/csv/move-cause-eff.csv'
into table aux_move_cause_eff 
fields terminated by ',' 
enclosed by '"'
lines terminated by '\n'
ignore 1 lines
(
move_code,
move_eff_code,
rate
);

delimiter &&
drop procedure if exists proc_insrt_move_cause_eff;
create procedure proc_insrt_move_cause_eff()
begin
	declare i int default 1;

    declare idMove int default 0;
    declare idMoveEff int default 0;

    declare intRate int default 0; 

    /*cur1 variables*/
    declare vMoveCode varchar(32) default '';
    declare vMoveEffCode varchar(32) default '';
    declare vRate varchar(32) default '';

    declare continueCur1 int default 1;
    declare cur1 cursor for select * from aux_move_cause_eff;
	declare continue handler for SQLSTATE '02000' set continueCur1 = 0;

    delete from move_cause_eff;    
    open cur1;
	while continueCur1=1 do
        fetch cur1 into 
            vMoveCode,
            vMoveEffCode,
            vRate;

        set idMove = 0;
        set idMoveEff = 0;

        if continueCur1 = 1 then
            select move_id into idMove 
                from move 
                where move_code = vMoveCode;

            select move_eff_id into idMoveEff 
                from move_eff 
                where move_eff_code = vMoveEffCode;

            if vRate = '' then
                set intRate = null;
            else
                set intRate = cast(vRate as unsigned);
            end if; 

            insert into move_cause_eff (
                move_id,
                move_eff_id,
                rate
            ) values (
                idMove,
                idMoveEff,
                intRate
            );
        end if;
	end while;
	close cur1;
    drop table if exists aux_move_cause_eff;
end
&&
delimiter ;
call proc_insrt_move_cause_eff();
