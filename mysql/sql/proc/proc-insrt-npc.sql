drop table if exists aux_npc;
create temporary table aux_npc (
    npc_code varchar(32),
    npc_name_en varchar(32),	
    npc_name_ja varchar(32),
    npc_title_code varchar(32)
);

load data infile '/home/alejandro/eclipse-workspace/kingin/mysql/csv/npc.csv'
into table aux_npc 
fields terminated by ',' 
enclosed by '"'
lines terminated by '\n'
ignore 1 lines
(
npc_code,
npc_name_en,	
npc_name_ja,
npc_title_code
);

delimiter &&
drop procedure if exists proc_insrt_npc;
create procedure proc_insrt_npc()
begin
	declare i int default 1;

    declare idNpcTitle int default 0;

    /*cur1 variables*/
    declare vNpcCode varchar(32) default '';
    declare vNpcNameEn varchar(32) default '';
    declare vNpcNameJa varchar(32) default '';
    declare vNpcTitle varchar(32) default '';

    declare continueCur1 int default 1;
    declare cur1 cursor for select * from aux_npc;
	declare continue handler for SQLSTATE '02000' set continueCur1 = 0;

    delete from npc;    
    open cur1;
	while continueCur1=1 do
        fetch cur1 into 
            vNpcCode, 
            vNpcNameEn, 
            vNpcNameJa,
            vNpcTitle;

        set idNpcTitle = 0;

        if continueCur1 = 1 then
            select npc_title_id into idNpcTitle 
                from npc_title 
                where npc_title_code = vNpcTitle;

            insert into npc (
                npc_code,
                npc_name_en,	
                npc_name_ja,
                npc_title_id
            ) values (
                vNpcCode,
                vNpcNameEn,
                vNpcNameJa,
                idNpcTitle
            );
        end if;
	end while;
	close cur1;
    drop table if exists aux_npc;
end
&&
delimiter ;
call proc_insrt_npc();
