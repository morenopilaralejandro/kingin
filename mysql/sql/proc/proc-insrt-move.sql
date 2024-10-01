drop table if exists aux_move;
create temporary table aux_move (
    move_code varchar(32),
    move_name_en varchar(32),
    move_name_ja varchar(32),
    move_pp varchar(32),
    move_bp varchar(32),
    move_ac varchar(32),
    move_prio varchar(32),
    move_is_bright varchar(32),
    move_is_king varchar(32),
    move_is_contact varchar(32),
    type varchar(32),
    move_cat varchar(32),
    move_trgt varchar(32),
    move_eff varchar(32),
    rate varchar(32)
);

load data infile '/home/alejandro/eclipse-workspace/kingin/mysql/csv/move.csv'
into table aux_move 
fields terminated by ',' 
enclosed by '"'
lines terminated by '\n'
ignore 1 lines
(
move_code,
move_name_en,
move_name_ja,
move_pp,
move_bp,
move_ac,
move_prio,
move_is_bright,
move_is_king,
move_is_contact,
type,
move_cat,
move_trgt,
move_eff,
rate
);

delimiter &&
drop procedure if exists proc_insrt_move;
create procedure proc_insrt_move()
begin
	declare i int default 1;

    declare idType int default 0;
    declare idMoveCat int default 0;
    declare idMoveTrgt int default 0;
    declare idMoveEff int default 0;
    declare idMoveMthd int default 0;

    declare intMovePp int default 0; 
    declare intMoveBp int default 0; 
    declare intMoveAc int default 0; 
    declare intMovePrio int default 0; 
    declare intRate int default 0; 

    declare boolMoveIsBright bool default false;
    declare boolMoveIsKing bool default false;
    declare boolMoveIsContact bool default false;

    /*cur1 variables*/
    declare vMoveCode varchar(32) default '';
    declare vMoveNameEn varchar(32) default '';
    declare vMoveNameJa varchar(32) default '';
    declare vMovePp varchar(32) default '';
    declare vMoveBp varchar(32) default '';
    declare vMoveAc varchar(32) default '';
    declare vMovePrio  varchar(32) default '';
    declare vMoveIsBright varchar(32) default '';
    declare vMoveIsKing varchar(32) default '';
    declare vMoveIsContact varchar(32) default '';
    declare vType varchar(32) default '';
    declare vMoveCat varchar(32) default '';
    declare vMoveTrgt varchar(32) default '';
    declare vMoveEff varchar(32) default '';
    declare vRate  varchar(32) default '';

    declare continueCur1 int default 1;
    declare cur1 cursor for select * from aux_move;
	declare continue handler for SQLSTATE '02000' set continueCur1 = 0;

    delete from move;    
    open cur1;
	while continueCur1=1 do
        fetch cur1 into
            vMoveCode,
            vMoveNameEn,
            vMoveNameJa,
            vMovePp,
            vMoveBp,
            vMoveAc,
            vMovePrio,
            vMoveIsBright,
            vMoveIsKing,
            vMoveIsContact,
            vType,
            vMoveCat,
            vMoveTrgt,
            vMoveEff,
            vRate;

        set idType = 0;
        set idMoveCat = 0;
        set idMoveTrgt = 0;
        set idMoveEff = 0;

        if continueCur1 = 1 then
            select type_id into idType 
                from type 
                where type_code = vType;

            select move_cat_id into idMoveCat 
                from move_cat 
                where move_cat_code = vMoveCat;

            select move_trgt_id into idMoveTrgt 
                from move_trgt 
                where move_trgt_code = lower(vMoveTrgt);

            select move_eff_id into idMoveEff 
                from move_eff 
                where move_eff_code = vMoveEff;

            select move_cat_id into idMoveCat 
                from move_cat 
                where move_cat_code = vMoveCat;

            set continueCur1 = 1;            

            if vMovePp = '' then
                set intMovePp = null;
            else
                set intMovePp = cast(vMovePp as unsigned);
            end if; 

            if vMoveBp = '' then
                set intMoveBp = null;
            else
                set intMoveBp = cast(vMoveBp as unsigned);
            end if; 

            if vMoveAc = '' then
                set intMoveAc = null;
            else
                set intMoveAc = cast(vMoveAc as unsigned);
            end if; 

            if vMovePrio = '' then
                set intMovePrio = null;
            else
                set intMovePrio = cast(vMovePrio as int);
            end if;

            if vRate = '' then
                set intRate = null;
            else
                set intRate = cast(vRate as unsigned);
            end if; 

            if lower(vMoveIsBright) = 'yes' then
                set boolMoveIsBright = true;
            end if;

            if lower(vMoveIsKing) = 'yes' then
                set boolMoveIsKing = true;
            end if;

            if lower(vMoveIsContact) = 'yes' then
                set boolMoveIsContact = true;
            end if;

            insert into move (
                move_id,
                move_code,
                move_name_en,
                move_name_ja,
                move_pp,
                move_bp,
                move_ac,
                move_prio,
                move_is_bright,
                move_is_king,
                move_is_contact,
                type_id,
                move_cat_id,
                move_trgt_id
            ) values (
                i,
                vMoveCode,
                vMoveNameEn,
                vMoveNameJa,
                intMovePp,
                intMoveBp,
                intMoveAc,
                intMovePrio,
                boolMoveIsBright,
                boolMoveIsKing,
                boolMoveIsContact,
                idType,
                idMoveCat,
                idMoveTrgt
            );

            if idMoveEff != 0 then
                insert into move_cause_eff (
                    move_id, 
                    move_eff_id, 
                    rate
                ) values(
                    i,
                    idMoveEff,
                    intRate
                );
            end if;
        end if;
        set i = i + 1;
	end while;
	close cur1;
    drop table if exists aux_move;
end
&&
delimiter ;
call proc_insrt_move();
