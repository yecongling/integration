import {lazy} from "react";

const Home = lazy(() => import('../pages/Home'))
const Home1 = lazy(() => import('../pages/Home1'))

const routes = [
    {
        path: '/home',
        component: Home
    },
    {
        path: '/home1',
        component: Home1
    }
]

export default routes;