import request from './Request.js'
export const getMassageNum=()=>{
    return request.get('/article/getmassagenum');
}