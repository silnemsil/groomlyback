-- Kustutab public schema (mis põhimõtteliselt kustutab kõik tabelid)
DROP SCHEMA IF EXISTS groomly CASCADE;
-- Loob uue public schema vajalikud õigused
CREATE SCHEMA groomly
-- taastab vajalikud andmebaasi õigused
    GRANT ALL ON SCHEMA groomly TO postgres;
GRANT ALL ON SCHEMA groomly TO PUBLIC;