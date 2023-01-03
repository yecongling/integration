/* 数据处理 */
import {AxiosRequestConfig} from "axios";
import {RequestOptions} from "/#/axios";

export interface CreateAxiosOptions extends AxiosRequestConfig {
    authenticationScheme?: string
    transform?: AxiosTransform;
    requestOptions?: RequestOptions;
}


export abstract class AxiosTransform {

}