#include<stdio.h>
#include<stdlib.h>

#define eleType int

typedef struct ListNode{
    eleType data;
    struct ListNode *next;
} ListNode;

typedef struct LinkedList{
    struct ListNode *head;
    size_t size;
} LinkedList;

void LinkedListCreate(LinkedList*list){
    list->head = NULL;
    list->size = 0;
}

void LinkedListDestroy(LinkedList *list){
    while(list->head){
        ListNode *temp = list->head;
        list->head = list->head->next;
        free(temp);
    }
    list->size = 0;

}

void LinkedListInsert(LinkedList*list,int index,eleType element){
    if(index<0||index>list->size){
        printf("插入位置非法");
        return;
    }

    ListNode *newNode = (ListNode *)malloc(sizeof(ListNode));
    newNode->data = element;
    if(index ==0 ){
        newNode->next = list->head;
        list->head = newNode;
    }else{
        ListNode *current = list->head;
        for (int j = 0; j < index - 1;j++){
            current = current->next;
        }
        newNode->next = current->next;
        current->next = newNode;
    }
    list->size++;
}