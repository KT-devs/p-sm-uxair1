liqiibase
    Прописываем путь на файл скрипта, производится в файле changelog-master.yaml в пакете db
    Создания самого скрипта в пакете changeset 
    Формат файла yaml
    
    Образец скрипта 
        databaseChangeLog:
-       changeSet:
        id: create-test
        author: Ivan 
        changes:
        - createTable:
        tableName: test
        columns:
        - column:
        name: id
        type: bigint
        autoIncrement: true
        constraints:
        primaryKey: true
        nullable: false
        - column:
        name: name
        type: varchar(200)
        constraints:
        nullable: false