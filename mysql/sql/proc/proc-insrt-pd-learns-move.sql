drop table if exists aux_pd_learns_move;
create temporary table aux_pd_learns_move (
    pd_code varchar(32),
    move_code varchar(32),
    move_lrn_code varchar(32),
    lv varchar(32)
);

load data infile '/home/alejandro/eclipse-workspace/kingin/mysql/csv/pd-learns-move.csv'
into table aux_pd_learns_move 
fields terminated by ',' 
enclosed by '"'
lines terminated by '\n'
ignore 1 lines
(
pd_code,
move_code,
move_lrn_code,
lv
);

delimiter &&
drop procedure if exists proc_insrt_pd_learns_move;
create procedure proc_insrt_pd_learns_move()
begin
	declare i int default 1;

    declare idPd int default 0;
    declare idMove int default 0;
    declare idMoveLrn int default 0;

    declare intLv int default 0; 

    /*cur1 variables*/
    declare vPdCode varchar(32) default '';    
    declare vMoveCode varchar(32) default '';
    declare vMoveLrnCode varchar(32) default '';
    declare vLv varchar(32) default '';

    declare continueCur1 int default 1;
    declare cur1 cursor for select * from aux_pd_learns_move;
	declare continue handler for SQLSTATE '02000' set continueCur1 = 0;

    delete from pd_learns_move;    
    open cur1;
	while continueCur1=1 do
        fetch cur1 into 
            vPdCode,
            vMoveCode,
            vMoveLrnCode,
            vLv;

        set idPd = 0;
        set idMove = 0;
        set idMoveLrn = 0;

        if continueCur1 = 1 then
            select pd_id into idPd 
                from pd 
                where pd_code = vPdCode;

            select move_id into idMove 
                from move 
                where move_code = vMoveCode;

            select move_lrn_id into idMoveLrn 
                from move_lrn 
                where move_lrn_code = vMoveLrnCode;

            if vLv = '' then
                set intLv = null;
            else
                set intLv = cast(vLv as unsigned);
            end if;

            insert into pd_learns_move (
                pd_id,
                move_id,
                move_lrn_id,
                lv
            ) values (
                idPd,
                idMove,
                idMoveLrn,
                intLv
            );
        end if;
	end while;
	close cur1;
    drop table if exists aux_pd_learns_move;
end
&&
delimiter ;
call proc_insrt_pd_learns_move();
