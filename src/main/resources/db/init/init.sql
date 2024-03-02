CREATE DATABASE burgerbox;
CREATE USER user_burgerbox WITH PASSWORD 'pass_burgerbox';

GRANT ALL ON DATABASE burgerbox TO user_burgerbox;
ALTER DATABASE burgerbox OWNER TO user_burgerbox;

GRANT USAGE ON SCHEMA public TO user_burgerbox;
GRANT SELECT, UPDATE, INSERT, DELETE ON ALL TABLES IN SCHEMA public TO user_burgerbox;
GRANT USAGE ON ALL SEQUENCES IN SCHEMA public TO user_burgerbox;
GRANT ALL ON SCHEMA burgerbox TO user_burgerbox;