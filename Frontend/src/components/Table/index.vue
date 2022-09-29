<template>
  <div>
    <div class="flex justify-start px-10 py-5">
      <el-button type="warning" @click="dialogFormVisible = true">
        Create List Item
      </el-button>
    </div>
    <!-- insert data dialog -->
    <el-dialog draggable v-model="dialogFormVisible" title="New List Item">
      <el-form :model="form">
        <el-form-item label="Message content" :label-width="formLabelWidth">
          <el-input v-model="form.message_content" autocomplete="off" />
        </el-form-item>
        <el-form-item label="Telegram group" :label-width="formLabelWidth">
          <el-input v-model="form.telegram_group" autocomplete="off" />
        </el-form-item>
        <el-form-item label="Status" :label-width="formLabelWidth">
          <el-input v-model="form.status" autocomplete="off" />
        </el-form-item>
        <el-form-item label="Type" :label-width="formLabelWidth">
          <el-input v-model="form.type" autocomplete="off" />
        </el-form-item>
        <el-form-item label="Send time" :label-width="formLabelWidth">
          <el-input v-model="form.send_time" autocomplete="off" />
        </el-form-item>
        <el-form-item label="Creation time" :label-width="formLabelWidth">
          <el-input v-model="form.creation_time" autocomplete="off" />
        </el-form-item>
        <el-form-item label="Creator" :label-width="formLabelWidth">
          <el-input v-model="form.creator" autocomplete="off" />
        </el-form-item>
      </el-form>
      <template #footer>
        <span class="dialog-footer">
          <el-button @click="dialogFormVisible = false">Cancel</el-button>
          <el-button type="primary" @click="submitForm">Submit</el-button>
        </span>
      </template>
    </el-dialog>

    <!-- edit data dialog -->
    <el-dialog draggable v-model="editFormVisible" title="Edit List Item">
      <el-form :model="editForm">
        <el-form-item label="Message content" :label-width="formLabelWidth">
          <el-input v-model="editForm.message_content" autocomplete="off" />
        </el-form-item>
        <el-form-item label="Telegram group" :label-width="formLabelWidth">
          <el-input v-model="editForm.telegram_group" autocomplete="off" />
        </el-form-item>
        <el-form-item label="Status" :label-width="formLabelWidth">
          <el-input v-model="editForm.status" autocomplete="off" />
        </el-form-item>
        <el-form-item label="Type" :label-width="formLabelWidth">
          <el-input v-model="editForm.type" autocomplete="off" />
        </el-form-item>
        <el-form-item label="Send time" :label-width="formLabelWidth">
          <el-input v-model="editForm.send_time" autocomplete="off" />
        </el-form-item>
        <el-form-item label="Creation time" :label-width="formLabelWidth">
          <el-input v-model="editForm.creation_time" autocomplete="off" disabled />
        </el-form-item>
        <el-form-item label="Creator" :label-width="formLabelWidth">
          <el-input v-model="editForm.creator" autocomplete="off" disabled />
        </el-form-item>
      </el-form>
      <template #footer>
        <span class="dialog-footer">
          <el-button @click="editFormVisible = false">Cancel</el-button>
          <el-button type="primary" @click="updateForm">Submit</el-button>
        </span>
      </template>
    </el-dialog>

    <div class="flex justify-center px-3 md:px-10">
      <el-table :data="tableData" border>
        <el-table-column prop="id" label="Message ID" width="140" sortable/>
        <el-table-column prop="content" label="Message Content" width="160" sortable/>
        <el-table-column prop="group" label="Telegram Group" sortable/>
        <el-table-column prop="status" label="Status" sortable/>
        <el-table-column prop="type" label="Type" sortable/>
        <el-table-column prop="sendTime" label="Send Time" sortable/>
        <el-table-column prop="creationTime" label="Creation Time" sortable/>
        <el-table-column prop="creator" label="Creator" sortable/>
        <el-table-column label="Operations" width="180">
          <template #default="scope">
            <el-button type="warning" @click="handleEdit(scope.$index, scope.row)">
              Edit
            </el-button>
            <el-popconfirm title="Are you sure to delete this?" @confirm="handleDelete(scope.$index, scope.row)">
              <template #reference>
                <el-button type="danger">
                  Delete
                </el-button>
              </template>
            </el-popconfirm>

          </template>
        </el-table-column>
      </el-table>
    </div>
  </div>
</template>

<script>
import axios from 'axios'
import { defineComponent } from 'vue'

const messageAPI = "http://localhost:5000/messages"

const config = {
  headers: {
    'Content-Type': 'application/json',
    "Access-Control-Allow-Origin": "*"
  }
};

const default_form = {
  message_content: '',
  telegram_group: '',
  status: '',
  type: '',
  send_time: '',
  creation_time: '',
  creator: '',
}

export default defineComponent({
  name: 'Table',
  data() {
    return {
      tableData: [
        //   {
        //   message_id: '1102354892',
        //   message_content: 'New coin release',
        //   telegram_group: 'All Telegram Groups',
        //   status: 'Pending',
        //   type: 'Scheduled',
        //   send_time: '2022-03-05 11:13:22(UTC)',
        //   creation_time: '2022-02-28 05:21:34(UTC)',
        //   creator: 'handsomeguy@binance.us'
        // }
      ],

      dialogFormVisible: false,
      editFormVisible: false,

      form: {
        message_content: '',
        telegram_group: '',
        status: '',
        type: '',
        send_time: '',
        creation_time: '',
        creator: '',
      },

      editForm: {
        message_content: '',
        telegram_group: '',
        status: '',
        type: '',
        send_time: '',
        creation_time: '',
        creator: '',
        message_id: '',
      },

      formLabelWidth: '160px',
    }
  },
  methods: {
    updateForm() {

      axios.put(messageAPI + `/${this.editForm.message_id}`, this.editForm, config).then(() => {
        this.editFormVisible = false
        this.getList()
      })

    },

    handleEdit(index, row) {
      this.editForm.message_content = row.content
      this.editForm.telegram_group = row.group
      this.editForm.status = row.status
      this.editForm.type = row.type
      this.editForm.send_time = row.sendTime
      this.editForm.creation_time = row.creationTime
      this.editForm.creator = row.creator
      this.editForm.message_id = row.id

      this.editFormVisible = true
    },

    handleDelete(index, row) {
      let del_id = row.id

      axios.delete(messageAPI + `/${del_id}`, config).then(() => {
        this.getList()
      })
    },

    submitForm() {
      let template = Object.assign({}, default_form)
      template.message_content = this.form.message_content
      template.telegram_group = this.form.telegram_group
      template.status = this.form.status
      template.type = this.form.type
      template.send_time = this.form.send_time
      template.creation_time = this.form.creation_time
      template.creator = this.form.creator

      // POST data
      axios.post(messageAPI, template, config).then(() => {
        this.getList()
      })

      this.form = Object.assign({}, default_form)

      this.dialogFormVisible = false
    },

    getList() {
      axios
        .get(messageAPI, config)
        .then(
          response => (
            this.tableData = response.data
          ))
    }
  },
  mounted() {
    axios
      .get(messageAPI, config)
      .then(
        response => (
          this.tableData = response.data
        ))
  }


})
</script>
