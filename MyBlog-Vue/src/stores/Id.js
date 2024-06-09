import {defineStore} from 'pinia';
import { ref } from 'vue';

export const useIdStore=defineStore('id',()=>{
    const id=ref('');
    
    const setIdStore=(newId)=>{
        id.value=newId;
    }
    
    const removeIdStore=()=>{
        id.value='';
    }

    return {id,setIdStore,removeIdStore }
})