drop table if exists aux_evo_fam;
create temporary table aux_evo_fam (
    evo_fam_code varchar(32)
);

load data infile '/home/alejandro/eclipse-workspace/kingin/mysql/csv/evo-fam.csv'
into table aux_evo_fam 
fields terminated by ',' 
enclosed by '"'
lines terminated by '\n'
ignore 1 lines
(
evo_fam_code
);

delimiter &&
drop procedure if exists proc_insrt_evo_fam;
create procedure proc_insrt_evo_fam()
begin
	declare i int default 1;

    /*cur1 variables*/
    declare vEvoFamCode varchar(32) default '';

    declare continueCur1 int default 1;
    declare cur1 cursor for select * from aux_evo_fam;
	declare continue handler for SQLSTATE '02000' set continueCur1 = 0;

    delete from evo_fam;    
    open cur1;
	while continueCur1=1 do
        fetch cur1 into 
            vEvoFamCode;
        if continueCur1 = 1 then
            insert into evo_fam (
                evo_fam_code
            ) values (
                vEvoFamCode
            );
        end if;
	end while;
	close cur1;
    drop table if exists aux_evo_fam;
end
&&
delimiter ;
call proc_insrt_evo_fam();
