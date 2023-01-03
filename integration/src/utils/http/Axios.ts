/* 封装axios */

import axios, {AxiosInstance} from "axios";
import {CreateAxiosOptions} from "./axiosTransform";

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
}