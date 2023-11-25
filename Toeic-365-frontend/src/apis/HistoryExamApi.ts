import * as BaseApi from "./BaseApi";

export const getHistoryExam = ({ id, page }: any): Promise<any> => {
    return BaseApi.getApi(`/api/history-exam/list-history-exam?id=${id}&page=${page || 0}&size=10`, {});
}