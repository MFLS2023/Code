#include<stdio.h>
#include<stdlib.h>

//定义顺序表
typedef struct{
    int *elements;
    size_t size;
    size_t capacity;
} SequentialList;

void SequentialListInit(SequentialList *list, int capacity){
    list->elements = (int *)malloc(sizeof(int) * capacity);
    list->size = 0;
    list->capacity = capacity;
    if (list->elements == NULL) {
        printf("Memory allocation failed.\n");
    }

}

void SequentialListDestroy(SequentialList *list){
    if(list->elements!=NULL){
        free(list->elements);
        list->elements = NULL;
        
    }
}

size_t SequentialListSize(const SequentialList *list){
    return list->size;
}
size_t SequentialListCapacity(const SequentialList*list){
    return list->capacity;
}


void SequentialListInsert(SequentialList * list,int index, int element){

    if(index<0||index>list->size){
        printf("Invalid Index\n");
        return;
    }

    if(list->size==list->capacity){
        list->capacity = list->capacity + (list->capacity >> 1);
        
        int *newElements = (int *)realloc(list->elements, sizeof(int)* list->capacity);
        if (newElements == NULL) {
            printf("Failed to allocate memory\n");
            return;
        }

        list->elements = newElements;
    }

    for (int i = list->size; i>index;i++){
        list->elements[i] = list->elements[i-1];
    }

    list->elements[index] = element;
    list->size++;

}

void SequentialListRemove(SequentialList *list,int index){
    if(index<0||index>list->size-1){
        printf("Invalid Remove");
        return;
    }
    
    for (int i = index; i < list->size-1;i++){
        list->elements[i] = list->elements[i + 1];
    }
    list->size--;
}

void SequentialListUpdate(SequentialList*list,int index,int element){
    if(index<0||index>list->size-1){
        printf("Invalid Update");
        return;
    }
    list->elements[index] = element;
}

int SequentialListFind(SequentialList*list,int element){
    for (int i = 0; i < list->size;i++){
        if(list->elements[i]==element){
            return i;
        }
    }
    return -1;
}

int SequentialListIndex(SequentialList * list,int index){
    if(index<0||index>list->size-1){
        printf("Invalid Index");
        return -1;
    }
    return list->elements[index];
}

int main(){
        printf("开始插入元素\n");

    SequentialList list;
    SequentialListInit(&list, 1);

    for (int i = 0; i < 10;i++){
        SequentialListInsert(&list,i, i * 10);
    }

    
    for (int i = 0; i < list.size;i++){
        printf("%d ", list.elements[i]);
    }
    

    SequentialListRemove(&list, 4);
    SequentialListUpdate(&list,3, 10000);


    printf("\n删除和更新后的 List\n");
    for (int i = 0; i < list.size;i++){
        printf("%d ", list.elements[i]);
    }

    printf("\n列表是否存在 500 %d",SequentialListFind(&list, 500));

    SequentialListDestroy(&list);
    if(!SequentialListSize(&list)){
        printf("未删除干净列表");
    }
    return 0;
}