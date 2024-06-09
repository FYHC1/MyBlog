import request from './Request.js'
export const getArticleListService=()=>{
    return request.get('/admin/getarticlelist');
}

export const addArticleService=(article)=>{
    return request.post('/admin/addarticle',article)
}

export const getArticleContenService=(id)=>{
    return request.get('/admin/getcontentbyid?id='+id)
}

export const updateArticleService=(article)=>{
    return request.put('/admin/updatearticle',article)
}

export const deleteArticleService=(id)=>{
    return request.delete('/admin/deletearticle?id'+id);
}