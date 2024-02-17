#include <stdio.h>
#include <stdlib.h>

struct student
{
    int ID;
    char Name[20];
    char Parents_name[20];
    char Address[50];
    char Dept[20];
    int Phone_number;
};

struct student std;

void print_heading(char st[])
{
    printf("%s", st);
}

void add_student()
{
    print_heading("\nAdd Record\n\n");
    FILE *file;
    file = fopen("record.txt", "ab");

    if(file==NULL)
    {
        printf("file doesn't exist");
    }
    else
    {
        printf("ID: ");
        scanf("%d", &std.ID);
        fflush(stdin);
        printf("Name: ");
        gets(std.Name);
        printf("Parent's Name: ");
        gets(std.Parents_name);
        printf("Address: ");
        gets(std.Address);
        printf("Department: ");
        gets(std.Dept);
        printf("Phone Number: ");
        scanf("%d", &std.Phone_number);
        fwrite(&std,sizeof(std), 1, file);
    }

    fclose(file);

}

void search_student()
{
    print_heading("\nSearch Student\n\n");
    int stu_id;
    int isFound = 0;

    printf("Enter ID to search: ");
    scanf("%d", &stu_id);
    FILE *file;
    file = fopen("record.txt", "rb");
    if(file==NULL)
    {
        printf("file doesn't exist");
    }
    else
    {
        while(fread(&std,sizeof(std),1,file)==1)
        {
            if(std.ID==stu_id)
            {
                isFound = 1;
                break;
            }
        }

        if(isFound==1)
        {
            printf("The Record is Found\n");
            printf("ID: %d\n", std.ID);
            printf("Name: %s\n", std.Name);
            printf("Parent's Name: %s\n", std.Parents_name);
            printf("Address: %s\n", std.Address);
            printf("Department: %s\n", std.Dept);
            printf("Phone Number: %d\n", std.Phone_number);
        }
        else
        {
            printf("Sorry! No record is Found in Database\n");
        }
    }

    fclose(file);
}

void modify_student()
{
    print_heading("\nModify Record\n\n");
    int stu_id,isFound=0;
    printf("Enter ID to Modify: ");
    scanf("%d", &stu_id);

    FILE *file;
    file = fopen("record.txt", "rb+");
    if(file==NULL)
    {
        printf("file doesn't exist");
    }
    else
    {
        while(fread(&std,sizeof(std),1,file))
        {
            if(std.ID==stu_id)
            {
                printf("ID: ");
                scanf("%d", &std.ID);
                fflush(stdin);
                printf("Name: ");
                gets(std.Name);
                printf("Parent's Name: ");
                gets(std.Parents_name);
                printf("Address: ");
                gets(std.Address);
                printf("Department: ");
                gets(std.Dept);
                printf("Phone Number: ");
                scanf("%d", &std.Phone_number);
                fseek(file,-sizeof(std),SEEK_CUR);
                fwrite(&std,sizeof(std),1,file);
                isFound=1;
                break;
            }
        }
        if(!isFound)
        {
            printf("Record No Found\n");
        }
    }

    fclose(file);
}

void delete_student()
{
    print_heading("\nDelete Record\n\n");
    int stu_id;
    printf("Enter Id to Delete Student Record: ");
    scanf("%d", &stu_id);

    FILE *file, *temp;

    file = fopen("record.txt","rb");
    temp = fopen("temp.txt", "wb");

    if(file==NULL)
    {
        printf("file doesn't exist");
    }
    else
    {
        while(fread(&std,sizeof(std),1,file)==1)
        {
            if(std.ID != stu_id)
            {
                fwrite(&std, sizeof(std), 1, temp);
            }
        }
    }

    fclose(file);
    fclose(temp);
    remove("record.txt");
    rename("temp.txt", "record.txt");
    printf("The record is successfully deleted\n");
}

int menu()
{
    int x;
    printf("1. Add Student\n");
    printf("2. Search Student\n");
    printf("3. Modify Student Record\n");
    printf("4. Delete Student Record\n");
    printf("5. Exit\n\n");
    printf("Enter your choice: ");
    scanf("%d", &x);
    return x;
}

void main()
{
    while(1)
    {
        system("cls");
        switch(menu())
        {
        case 1:
            add_student();
            break;
        case 2:
            search_student();
            break;
        case 3:
            modify_student();
            break;
        case 4:
            delete_student();
            break;
        case 5:
            exit(0);
        default:
            printf("Choice Correct Number\n");
        }
        system("pause");
    }
    getch();
}
