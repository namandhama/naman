package com.example.namandhama.myapplication;


import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Note")
public class Note {

    @DatabaseField(generatedId = true)
    int id;

    @DatabaseField
    String subject;

    @DatabaseField
    String text;



public Note()
{

}

    public Note(String subject, String text) {
        this.subject = subject;
        this.text = text;

    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
