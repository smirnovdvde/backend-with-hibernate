do
$$
begin
for counter in 1..500000 loop
	insert into many_rows (name) values ('name' || counter);
end loop;
end;
$$;