class BaseComputeDriver(object):
    def handle(self, req):
        name = req.name[len("compute."):].replace(".","_")
        if hasattr(self, name):
            getattr(self, name)(req = req, **req.data.__dict__)
        else:
            print "Unhandled method", name
