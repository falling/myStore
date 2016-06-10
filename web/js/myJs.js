/**
 * Created by falling on 2016/6/10.
 */
//根据数值获取对应的ID
function getState(state) {
    if (state == 0) {
        return "未接单";
    } else if (state == 1) {
        return "已接单";
    } else if (state == 2) {
        return "已经完成";
    }
}

//格式化输出时间
function getTime(time) {
    var t = new Date(time);
    return t.getFullYear() + "年" + (t.getMonth() + 1) + "月" + t.getDate() + "日" + " " + t.getHours() + ":" + t.getMinutes() + ":" + t.getSeconds();
}
