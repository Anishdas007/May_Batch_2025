import { Routes } from '@angular/router';
import { Parent } from './component/parent/parent';

export const routes: Routes = [
    {
        path:'',
        redirectTo:'/view',
        pathMatch: 'full'
    },
    // {
    //     path: 'forms',
    //     component:FormComponent
    // },
    // {
    //     path: 'directives',
    //     component:DirectiveComponent
    // },
    {
        path: 'view',
        component:Parent
    }
];
