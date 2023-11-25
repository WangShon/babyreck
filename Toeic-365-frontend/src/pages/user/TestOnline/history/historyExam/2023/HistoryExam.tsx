import React, { useEffect, useState } from 'react';
import { Link, useParams } from 'react-router-dom';
import NavbarComponent from '../../../../../../components/user/home/navbar.component';
import { Pagination, Table } from 'antd';
import type { ColumnsType, TableProps } from 'antd/es/table';
import "./../../../library/bootstrap";
import "./../../../library/bootstrap.min.scoped.css";
import "./HistoryExam.scoped.css";
import * as HistoryExamApi from "../../../../../../apis/HistoryExamApi";

interface DataType {
  key: React.Key;
  timeOfExam: number;
  listeningScore: number;
  readingScore: number;
  examName: string;
}

const columns: ColumnsType<DataType> = [
  {
    title: 'Time Of Exam',
    dataIndex: 'timeOfExam',
    sorter: {
      compare: (a, b) => a.timeOfExam - b.timeOfExam,
      multiple: 3,
    },
  },
  {
    title: 'Exam Name',
    dataIndex: 'examName',
  },
  {
    title: 'Listening Score',
    dataIndex: 'listeningScore',
    sorter: {
      compare: (a, b) => a.listeningScore - b.listeningScore,
      multiple: 3,
    },
  },
  {
    title: 'Reading Score',
    dataIndex: 'readingScore',
    sorter: {
      compare: (a, b) => a.readingScore - b.readingScore,
      multiple: 2,
    },
  },
];

const HistoryExam: React.FC = () => {

  const params: any = useParams()
  const [page, setPage] = useState<number>(0)
  const [totalElement, setTotalElements] = useState<number>()

  const id = params?.id

  const [historyExam, setHistoryExam]: any = useState([]);
  const getHistoryExam = async () => {
    try {
      const response = await HistoryExamApi.getHistoryExam({ id, page });

      setHistoryExam(response.data.content);
      setTotalElements(response.data.totalElements)
    } catch (error: any) {
      console.log(error.message);
    }
  };

  useEffect(() => {
    getHistoryExam();
  }, [page])

  const handlePageChange = (page: number, pageSize?: number | undefined) => {
    setPage(page - 1)
  };

  return (
    <>
      <NavbarComponent />

      <div className="container layout-main">
        <Table columns={columns} dataSource={historyExam} pagination={false} />
        <div className='mt-3' style={{ display: "flex", justifyContent: "flex-end" }}>
          <Pagination defaultCurrent={1} total={totalElement} onChange={handlePageChange} current={page + 1} />
        </div>

      </div>
      <footer className="text-center text-white footer">
        <div className="container p-4">
          <section className="mb-4">
            <Link className="btn btn-outline-light btn-floating m-1" to="#!" role="button"><i className="pi pi-facebook" /></Link>
            <Link className="btn btn-outline-light btn-floating m-1" to="#!" role="button"><i className="pi pi-twitter" /></Link>
            <Link className="btn btn-outline-light btn-floating m-1" to="#!" role="button"><i className="pi pi-google" /></Link>
            <Link className="btn btn-outline-light btn-floating m-1" to="#!" role="button"><i className="pi pi-github" /></Link>
          </section>
          <section>
            <form>
              <div className="row d-flex justify-content-center">
                <div className="col-auto">
                  <p className="pt-2">
                    <strong>Email hỗ trợ</strong>
                  </p>
                </div>
                <div className="col-md-5 col-12">
                  <div className="form-outline form-white mb-4">
                    <input type="email" id="form5Example2" placeholder="toeic365@gmail.com" className="form-control" />
                  </div>
                </div>
                <div className="col-auto">
                  <button type="submit" className="btn btn-outline-light mb-4">
                    Gửi
                  </button>
                </div>
              </div>
            </form>
          </section>
        </div>
        <div className="text-center p-3" style={{ backgroundColor: 'rgba(0, 0, 0, 0.2)' }}>
          © 2023 Copyright:
          <Link className="text-white" to="#"> Toeic365.com</Link>
        </div>
      </footer>
    </>


  );
};

export default HistoryExam;