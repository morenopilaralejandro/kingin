drop table if exists aux_evo_cond;
create temporary table aux_evo_cond (
    evo_cond_code varchar(32),
    evo_cond_desc_en varchar(32),	
    evo_cond_desc_ja varchar(32)
);

load data infile '/home/alejandro/eclipse-workspace/kingin/mysql/csv/evo-cond.csv'
into table aux_evo_cond 
fields terminated by ',' 
enclosed by '"'
lines terminated by '\n'
ignore 1 lines
(
evo_cond_code,
evo_cond_desc_en,	
evo_cond_desc_ja
);

delimiter &&
drop procedure if exists proc_insrt_evo_cond;
create procedure proc_insrt_evo_cond()
begin
	declare i int default 1;

    /*cur1 variables*/
    declare vEvoCondCode varchar(32) default '';
    declare vEvoCondDescEn varchar(32) default '';
    declare vEvoCondDescJa varchar(32) default '';

    declare continueCur1 int default 1;
    declare cur1 cursor for select * from aux_evo_cond;
	declare continue handler for SQLSTATE '02000' set continueCur1 = 0;

    delete from evo_cond;    
    open cur1;
	while continueCur1=1 do
        fetch cur1 into 
            vEvoCondCode, 
            vEvoCondDescEn, 
            vEvoCondDescJa;
        if continueCur1 = 1 then
            insert into evo_cond (
                evo_cond_code,
                evo_cond_desc_en,	
                evo_cond_desc_ja
            ) values (
                vEvoCondCode,
                vEvoCondDescEn,
                vEvoCondDescJa
            );
        end if;
	end while;
	close cur1;
    drop table if exists aux_evo_cond;
end
&&
delimiter ;
call proc_insrt_evo_cond();
