drop table if exists aux_egg_cyc;
create temporary table aux_egg_cyc (
    egg_cyc_code varchar(32),
    egg_cyc_val int
);

load data infile '/home/alejandro/eclipse-workspace/kingin/mysql/csv/egg-cyc.csv'
into table aux_egg_cyc 
fields terminated by ',' 
enclosed by '"'
lines terminated by '\n'
ignore 1 lines
(
egg_cyc_code,
egg_cyc_val
);

delimiter &&
drop procedure if exists proc_insrt_egg_cyc;
create procedure proc_insrt_egg_cyc()
begin
	declare i int default 1;

    /*cur1 variables*/
    declare vEggCycCode varchar(32) default '';
    declare vEggCycVal int default 0;

    declare continueCur1 int default 1;
    declare cur1 cursor for select * from aux_egg_cyc;
	declare continue handler for SQLSTATE '02000' set continueCur1 = 0;

    delete from egg_cyc;    
    open cur1;
	while continueCur1=1 do
        fetch cur1 into 
            vEggCycCode,
            vEggCycVal;

        if continueCur1 = 1 then
            insert into egg_cyc (
                egg_cyc_code,
                egg_cyc_val
            ) values (
                vEggCycCode,
                vEggCycVal
            );
        end if;
	end while;
	close cur1;
    drop table if exists aux_egg_cyc;
end
&&
delimiter ;
call proc_insrt_egg_cyc();
