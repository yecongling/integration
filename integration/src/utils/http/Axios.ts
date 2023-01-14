/* 封装axios */

import axios, {AxiosError, AxiosInstance, AxiosRequestConfig, AxiosResponse} from "axios";
import {CreateAxiosOptions} from "./axiosTransform";
import {RequestOptions, Result} from "/#/axios";

export class RAxios{
    private axiosInstance: AxiosInstance;
    private readonly options: CreateAxiosOptions;

    constructor(options: CreateAxiosOptions) {
        this.options = options;
        this.axiosInstance = axios.create(options);
        this.setupInterceptors();
    }

    /**
     * 拦截器配置
     *
     * @private
     */
    private setupInterceptors() {

    }

    /**
     * 封装请求
     * @param config 请求配置
     * @param options 请求项
     */
    request<T = any>(config: AxiosRequestConfig, options?: RequestOptions): Promise<T> {
        return new Promise((resolve, reject) => {
            this.axiosInstance
                .request<any, AxiosResponse<Result>>(config)
                .then((res: AxiosResponse<Result>) => {
                    const {data} = res;
                    resolve(data as unknown as Promise<T>);
                })
                .catch((e: Error | AxiosError) => {
                    reject(e);
                })
        })
    }

    /**
     * 封装post请求
     */
    post<T = any> (config: AxiosRequestConfig, options?: RequestOptions): Promise<T> {
        return this.request({...config, method: 'POST'}, options);
    }
}