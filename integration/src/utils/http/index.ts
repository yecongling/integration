/**
 * 封装请求模块
 *
 */
import {CreateAxiosOptions} from "@/utils/http/axiosTransform";
import {RAxios} from "@/utils/http/Axios";
import {deepMerge} from "@/utils";

function createAxios(opts?: Partial<CreateAxiosOptions>) {
    return new RAxios(
        deepMerge(
            {
                authenticationScheme: '',
                timeout: 10 * 1000,
            },
            opts || {}
        )
    );
}

export const defHttp = createAxios();