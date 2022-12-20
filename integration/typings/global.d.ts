declare const PUBLIC_URL: string

declare interface IKeyStringProps {
    [key: string]: any
}

declare type TSetKeyStringProps = IKeyStringProps[]

declare const TThemeFields: ['light', 'dark', 'purple', 'orange', 'pink']

declare type TThemeField = typeof TThemeFields[number]

declare interface Window {
    g_app: any
    g_history: IKeyStringProps
    g_config: {
        name: string
        enName: string
        logo: string
        apiRoot: string
        themes: any
        defaultTheme: TThemeField
        isProd: boolean
        publicPath: string
        loginAddress: string
    }
    Highcharts: any
}

declare type TStringGroup = string[]

declare type TLoadingConfigProps =
    | {
    isFullScreen?: boolean
    customLoading?: React.ReactNode
}
    | boolean

declare interface IRouteItemProps<T> extends IKeyStringProps {
    component?: string | Function
    icon?: string
    title?: string
    navHide?: string
    routes?: T[]
    search?: string
    redirect?: string
    isCarryPath?: boolean
    authority?: string[]
    models?: string[]
    componentFrom?: string
    loadingConfig?: TLoadingConfigProps
}

declare interface IRouteItem extends IRouteItemProps<IRouteItem> {
    path: string
}

declare interface IUserInfoProps {
    authority?: string
    userId?: number
    userName?: string
}

declare interface IUserInfo {
    userInfo: IUserInfoProps
}

declare interface IConfigInfoProps extends IKeyStringProps {
    isFixedSide?: boolean
    isFixedHeader?: boolean
    showLineNumbers?: boolean
    codeTheme?: string
}

declare interface ISharedProps {
    collapsed?: boolean
    foldMenu?: boolean
    configInfo?: IConfigInfoProps
    userInfo: IUserInfoProps
}