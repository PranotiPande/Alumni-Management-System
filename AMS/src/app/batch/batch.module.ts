import {NgModule} from '@angular/core';
import { CommonModule } from "@angular/common";
import { FormsModule } from "@angular/forms";
import { BatchComponent } from "./batch/batch.component";
import { BatchFormComponent } from '../batch/batch-form/batch-form.component';

@NgModule({
    declarations:[
        BatchComponent,
        BatchFormComponent
    ],
    imports:[
        FormsModule,
        CommonModule
    ],
    exports:[
        BatchComponent
    ]
})
export class BatchModule{}