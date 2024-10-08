drop table if exists aux_exp_grp;
create temporary table aux_exp_grp (
    exp_grp_code varchar(32),
    exp_grp_name_en varchar(32),
    exp_grp_name_ja varchar(32),
    exp_grp_final int

);

load data infile '/home/alejandro/eclipse-workspace/kingin/mysql/csv/exp-grp.csv'
into table aux_exp_grp 
fields terminated by ',' 
enclosed by '"'
lines terminated by '\n'
ignore 1 lines
(
exp_grp_code,
exp_grp_name_en,
exp_grp_name_ja,
exp_grp_final
);

delimiter &&
drop procedure if exists proc_insrt_exp_grp;
create procedure proc_insrt_exp_grp()
begin
	declare i int default 1;

    /*cur1 variables*/
    declare vExpGrpCode varchar(32) default '';
    declare vExpGrpNameEn varchar(32) default '';
    declare vExpGrpNameJa varchar(32) default '';
    declare vExpGrpFinal int default 0;

    declare continueCur1 int default 1;
    declare cur1 cursor for select * from aux_exp_grp;
	declare continue handler for SQLSTATE '02000' set continueCur1 = 0;

    delete from exp_grp;    
    open cur1;
	while continueCur1=1 do
        fetch cur1 into 
            vExpGrpCode,
            vExpGrpNameEn,
            vExpGrpNameJa,
            vExpGrpFinal;

        if continueCur1 = 1 then
            insert into exp_grp (
                exp_grp_code,
                exp_grp_name_en,
                exp_grp_name_ja,
                exp_grp_final
            ) values (
                vExpGrpCode,
                vExpGrpNameEn,
                vExpGrpNameJa,
                vExpGrpFinal
            );
        end if;
	end while;
	close cur1;
    drop table if exists aux_exp_grp;
end
&&
delimiter ;
call proc_insrt_exp_grp();
