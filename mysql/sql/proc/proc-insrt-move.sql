drop table if exists aux_move;
create temporary table aux_move (
    move_code varchar(32),
    move_name_en varchar(32),
    move_name_ja varchar(32),
    move_pp int,
    move_bp int,
    move_ac int,
    move_prio int,
    move_is_bright varchar(32),
    move_is_king varchar(32),
    move_is_contact varchar(32),
    type varchar(32),
    move_cat varchar(32),
    move_trgt varchar(32),
    move_eff varchar(32),
    rate int,
    move_mthd varchar(32)
);

load data infile '/home/alejandro/eclipse-workspace/kingin/mysql/csv/move.csv'
into table aux_move 
fields terminated by ',' 
enclosed by '"'
lines terminated by '\n'
ignore 1 lines
(
move_code
move_name_en
move_name_ja
move_pp
move_bp
move_ac
move_prio
move_is_bright
move_is_king
move_is_contact
type
move_cat
move_trgt
move_eff
rate
move_mthd
);

delimiter &&
drop procedure if exists proc_insrt_move;
create procedure proc_insrt_move()
begin
	declare i int default 1;
    declare id

    /*cur1 variables*/
    declare vMoveCode varchar(32) default '';
    declare vMoveNameEn varchar(32) default '';
    declare vMoveNameJa varchar(32) default '';
    declare vMovePp int default 0;
    declare vMoveBp int default 0;
    declare vMoveAc int default 0;
    declare vMovePrio int default 0;
    declare vMoveIsBright varchar(32) default '';
    declare vMoveIsKing varchar(32) default '';
    declare vMoveIsContact varchar(32) default '';
    declare vType varchar(32) default '';
    declare vMoveCat varchar(32) default '';
    declare vMoveTrgt varchar(32) default '';
    declare vMoveEff varchar(32) default '';
    declare vRate int default 0;
    declare vMoveMthd varchar(32) default '';


    declare continueCur1 int default 1;
    declare cur1 cursor for select * from aux_move;
	declare continue handler for SQLSTATE '02000' set continueCur1 = 0;

    delete from move;    
    open cur1;
	while continueCur1=1 do
        fetch cur1 into v;
        if continueCur1 = 1 then
            /*TODO*/
            insert into move(
                move_code
                move_name_en
                move_name_ja
                move_pp
                move_bp
                move_ac
                move_prio
                move_is_bright
                move_is_king
                move_is_contact
                type
                move_cat_id
                move_trgt_id
                )
                values (
                vMoveCode
                vMoveNameEn
                vMoveNameJa
                vMovePp
                vMoveBp
                vMoveAc
                vMovePrio
                vMoveIsBright
                vMoveIsKing
                vMoveIsContact
                vType
                vMoveCat
                vMoveTrgt);
        end if;
	end while;
	close cur1;
    drop table if exists aux_move;
end
&&
delimiter ;
call proc_insrt_move();
