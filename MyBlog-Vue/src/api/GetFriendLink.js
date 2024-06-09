import request from './Request.js'
export const getFriendLink=()=>{
    return Request.get('/friendlink/getfriendlink')
}